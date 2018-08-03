package com.dlsmartercity.annualaccount.util;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * 各地图API坐标系统比较与转换;
 * WGS84坐标系：即地球坐标系，国际上通用的坐标系。设备一般包含GPS芯片或者北斗芯片获取的经纬度为WGS84地理坐标系,
 * 谷歌地图采用的是WGS84地理坐标系（中国范围除外）;
 * GCJ02坐标系：即火星坐标系，是由中国国家测绘局制订的地理信息系统的坐标系统。由WGS84坐标系经加密后的坐标系。
 * 谷歌中国地图和搜搜中国地图采用的是GCJ02地理坐标系; BD09坐标系：即百度坐标系，GCJ02坐标系经加密后的坐标系;
 * 搜狗坐标系、图吧坐标系等，估计也是在GCJ02基础上加密而成的。
 */
public class PositionUtil {
	public static final String BAIDU_LBS_TYPE = "bd09ll";

	public static double pi = 3.1415926535897932384626;
	public static double a = 6378245.0;
	public static double ee = 0.00669342162296594323;
	
	public static enum CSYS {
		/**
		 * 火星坐标系
		 */
		GCJ02,
		/**
		 * 百度地图坐标系
		 */
		BD09,
		/**
		 * wgs84
		 */
		GPS84;
	}
	
	/**
	 * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==> Mars Geodetic System
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static Gps gps84ToGcj02(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return null;
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	/**
	 * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
	 */
	public static Gps gcj02ToGps84(double lat, double lon) {
		Gps gps = transform(lat, lon);
		double lontitude = lon * 2 - gps.getWgLon();
		double latitude = lat * 2 - gps.getWgLat();
		return new Gps(latitude, lontitude);
	}

	/**
	 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
	 * 
	 * @param gg_lat
	 * @param gg_lon
	 */
	public static Gps gcj02ToBd09(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new Gps(bd_lat, bd_lon);
	}

	/**
	 * * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 *
	 * * @param bd_lat * @param bd_lon * @return
	 */
	public static Gps bd09ToGcj02(double bd_lat, double bd_lon) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new Gps(gg_lat, gg_lon);
	}

	/**
	 * (BD-09)-->84
	 * 
	 * @param bd_lat
	 * @param bd_lon
	 * @return
	 */
	public static Gps bd09ToGps84(double bd_lat, double bd_lon) {

		Gps gcj02 = PositionUtil.bd09ToGcj02(bd_lat, bd_lon);
		Gps map84 = PositionUtil.gcj02ToGps84(gcj02.getWgLat(), gcj02.getWgLon());
		return map84;

	}
	
	
	public static Gps gps84Tobd09(double bd_lat, double bd_lon) {
		Gps gps84 = PositionUtil.gps84ToGcj02(bd_lat, bd_lon);
		if(gps84 == null)
			return null;
		Gps mapbd09 = PositionUtil.gcj02ToBd09(gps84.getWgLat(), gps84.getWgLon());
		return mapbd09;

	}

	public static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	public static Gps transform(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return new Gps(lat, lon);
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	public static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	public static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}
	
	/**
	 * 计算点是否在区域范围内
	 * 
	 * 方法一 未测试
	 * 
	 * @param point 测试点
	 * @param polygon 范围点的集合
	 * 
	 * @return 是否在范围内
	 */
	public boolean checkWithJdkGeneralPath(Point2D.Double point, List<Point2D.Double> polygon) {
		java.awt.geom.GeneralPath p = new java.awt.geom.GeneralPath();
		Point2D.Double first = polygon.get(0);
		p.moveTo(first.x, first.y);
		for (Point2D.Double d : polygon) {
			p.lineTo(d.x, d.y);
		}
		p.lineTo(first.x, first.y);
		p.closePath();
		return p.contains(point);
	}
	  
	/**
	 * 计算点是否在区域范围内
	 * 
	 * 方法二 未测试
	 * 
	 * @param point 测试点
	 * @param polygon 范围点的集合
	 * @return 是否在范围内
	 */
	public boolean checkWithJdkPolygon(Point2D.Double point, List<Point2D.Double> polygon) {
	    java.awt.Polygon p = new Polygon();
	    // java.awt.geom.GeneralPath
	    final int TIMES = 1000000;
	    for (Point2D.Double d : polygon) {
	        int x = (int) d.x * TIMES;
	        int y = (int) d.y * TIMES;
	        p.addPoint(x, y);
	    }
	    int x = (int) point.x * TIMES;
	    int y = (int) point.y * TIMES;
	    return p.contains(x, y);
	}
	
	/**
	 * 
	 * @param source 原坐标系
	 * @param lat 原经度
	 * @param lon 原纬度
	 * @param target 目标坐标系
	 * @return
	 */
	public static Gps transform(CSYS source, double lat, double lon, CSYS target) {
		Gps gps = null;
		switch(source) {
		case GCJ02:
			switch(target) {
			case BD09:
				gps = gcj02ToBd09(lat, lon);
				break;
			case GCJ02:
				gps = new Gps(lat, lon);
				break;
			case GPS84:
				gps = gcj02ToBd09(lat, lon);
				break;
			default:
				break;
			}
			break;
		case BD09:
			switch(target) {
			case BD09:
				gps = new Gps(lat, lon);
				break;
			case GCJ02:
				gps = bd09ToGcj02(lat, lon);
				break;
			case GPS84:
				gps = bd09ToGps84(lat, lon);
				break;
			default:
				break;
			}
			break;
		case GPS84:
			switch(target) {
			case BD09:
				gps = gps84Tobd09(lat, lon);
				break;
			case GCJ02:
				gps = gps84ToGcj02(lat, lon);
				break;
			case GPS84:
				gps = new Gps(lat, lon);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return gps;
	}

	public static void main(String[] args) {

		// 北斗芯片获取的经纬度为WGS84地理坐标 31.426896,119.496145
		Gps gps = new Gps(31.426896, 119.496145);
		System.out.println("gps :" + gps);
		Gps gcj = gps84ToGcj02(gps.getWgLat(), gps.getWgLon());
		System.out.println("gcj :" + gcj);
		Gps star = gcj02ToGps84(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("star:" + star);
		Gps bd = gcj02ToBd09(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("bd  :" + bd);
		Gps gcj2 = bd09ToGcj02(bd.getWgLat(), bd.getWgLon());
		System.out.println("gcj :" + gcj2);
		
		Gps bd09 = gps84Tobd09(gps.getWgLat(), gps.getWgLon());
		System.out.println("bd09 :" + bd09);
		
		Gps gps84 = bd09ToGps84(bd09.getWgLat(), bd09.getWgLon());
		System.out.println("gps84 :" + gps84);
	}
}
