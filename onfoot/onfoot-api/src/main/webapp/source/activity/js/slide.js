$(function (){
	 $(".alert-box").on("click",function(){
	    	$(".alert-box").hide();
	    });
	$("img.music").addClass("musicimg");
	/*$(".rule").on('click', function () {
		top.location.href = "/"+msUrl+'/annual/rule/2017';
		})*/
    function getData(url, paramsObj) {
        if (!url) {
            return;
        } else {
            return $.getJSON({
                url: url,
                data: paramsObj || {},
                async: false,
                dataType: 'json'
            }).responseJSON;
        }
    };

    $(window).on('resize.rem', function() {
        var rem = 7.5;
        $('html').css('font-size', $(window).width() / rem);
    }).trigger('resize.rem');

    var uid = $("#uid").val();
    var data = getData(generateurl + "?uid=" + uid); //TODO

    //	 if (data.reportflag == 1) {
    //        $("#swiper").css("display","block");
    //        $("#end").css("display","none");
    var mySwiper = new Swiper('.swiper-container', {
        on: {
            init: function() {
                swiperAnimateCache(this); //隐藏动画元素 
                swiperAnimate(this); //初始化完成开始动画
            },
            slideChangeTransitionEnd: function() {
                swiperAnimate(this); //每个slide切换结束时也运行当前slide动画
            }
        },
        direction: 'vertical',
        slidesPerView: 1,
        // spaceBetween: 30,
        mousewheel: true,
        speed: 100,
        shortSwipes: true,
        initialSlide: location.search.indexOf('goBack') > -1 ? $('div.swiper-slide').index($('div.slide-9')) : 0
    });

    $("img.music").on('click touch', function() {
        $("img.music").toggleClass("musicimg");
        if ($("img.music").hasClass("musicimg")) {
            audio.play();
        } else {
            audio.pause();
        }
    });

    if (data.retcode == "0000" && data.data.reportflag == 1) {
        data = data.data;
        var uid = data.uid;
        var openRed = data.redPacket;
      /*  var $page = $('div.swiper-slide');*/
        
        mySwiper.removeSlide($('div.swiper-slide').index($('div.slide-0')));
        
        if (data.rewardflag == 0) {
            mySwiper.removeSlide($('div.swiper-slide').index($('div.slide-3')));
        }

        if (data.redbagflag == 1) {
            //$("#redbags").remove();
            mySwiper.removeSlide($('div.swiper-slide').index($('div.slide-8')));
            $('#ranks').attr("href", rankingpage + '?uid=' + $("#uid").val());
        } else {
            //$("#redPacket").remove();
            mySwiper.removeSlide($('div.swiper-slide').index($('div.slide-9')));
            var activityflg= data.activityflg;
	       	
	       		
	       			 $('#openA').on("click",function(){
	       				 if(activityflg==1){
	       					$('.spinner').show();
	       					$('.slide-8').addClass('swiper-no-swiping');
	    	       			 $('#openA').attr("href", endYearUserReward + '?uid=' + $("#uid").val());
//	    	       			 window.location.href=endYearUserReward+'?uid=' + $("#uid").val();
	    	       		 }else if(activityflg==2){
			       			 $(".alert-box").text("活动未开始");
			       			 $(".alert-box").show();
			       			 setTimeout(function(){$(".alert-box").hide();}, 1000);
				       		 }else if(activityflg==3){
				       			 $(".alert-box").text("活动已结束");
				       			 $(".alert-box").show();
				       			 setTimeout(function(){$(".alert-box").hide();}, 1000);
				       		 }
	       			})
	       	 
 }


        //one
        $("#joinTime").html(data.registDate);
        $("#joinNum").html(data.registDays);
        $(".nicheng").append('<img class="headPortrait" src="' + data.hurl + '" alt="头像"><div>' + data.uname + '</div>');

        //two
        $("#reportTime").html(data.firstReportDate);
        $(".caseImg").attr("src", data.firsrImgUrl);
        $("#addrDescribe").html(data.firstDesc);
        $("#address").html(data.firstPosition);

        //three
        $("#grantTime").html(data.firstRewardDate);
        $("#grantAward").html(data.firstRewardAmt);

        //four
        ;(function() {
            $("#score").html(data.exceedPercent);
            $("#uploadNum").html(data.reportEventCnt);
            $("#taskNum").html(data.finishTaskCnt);
            $("#awardNum").html(data.rewardAmt);
            data.imgList.forEach(function(value, index, array) {
                $("#uploadImgs").after('<img class="img' + index + '" src="' + value.imgUrl + '">');
            });
            if (data.rewardCommentTwo != null) {
                $("#comment").append('<div>' + data.rewardCommentOne + '</div><div>' + data.rewardCommentTwo + '</div >');
            } else {
                $("#comment").append('<div>' + data.rewardCommentOne + '</div>');
            }
        })();

        //five
        ;(function() {
            //             var container = document.getElementById('myChart');
            var myChart = echarts.init(document.getElementById('myChart'));
            var seriesData = [];
            //             var resizeWorldMapContainer = function () {
            //                 container.style.width = window.innerWidth + 'px';
            //                 container.style.height = window.innerHeight + 'px';
            //             };
            //
            //             resizeWorldMapContainer();

            for (var i = 0; i < data.reportList.length; i++) {
                seriesData.push({
                    name: data.reportList[i].typeName,
                    value: data.reportList[i].cnt
                });
            }

            // 指定图表的配置项和数据
            var option = {
                color: ['#fdfc00', '#adf1ff', '#4acb8a', '#f6e3b4', '#f7bbf5', '#ed75ae', '#a340ff'],
                calculable: true,
                series: [{
                    name: "oo",
                    type: 'pie',
                    radius: ['20%', '54%'],
                    center: ['51%', '50%'],
                    labelLine: {
                        normal: {
                            length2: 58,
                            length: 20
                        }
                    },
                    label: {
                        normal: {
                            formatter: '{b}\n\n{c}',
                            fontSize: 14,
                            padding: [0, -57],
                            rich: {
                                a: {
                                    verticalAlign: 'top',
                                    //  lineHeight: 22
                                },
                                hr: {
                                    borderColor: '#eee',
                                    width: '100%',
                                    borderWidth: 1,
                                    height: 0
                                },
                                b: {
                                    verticalAlign: 'bottom',
                                    //   lineHeight: 22
                                },
                            }
                        }
                    },
                    data: seriesData,
                }]
            };
            myChart.setOption(option);
            window.onresize = function() {
                //重置容器高宽
                //                 resizeWorldMapContainer();
                myChart.resize();
            };

            $("#uploadType").html(data.reportTypeNameMost);
        })();

        //six
        ;(function() {
            $("#goWalk").append('<div class="textLeft textBig">' + data.distanceDesc + '<span class="textYellow">' + data.distanceCnt + '</span></div >');
            if (data.distanceType == 4) {
                $(".walkImg").append('<img src="activity/img/product4@3x.png" alt="">');
            } else if (data.distanceType == 3) {
                $(".walkImg").append('<img src="activity/img/product3@3x.png" alt="">');
            } else if (data.distanceType == 2) {
                $(".walkImg").append('<img src="activity/img/product2@3x.png" alt="">');
            } else {
                $(".walkImg").append('<img src="activity/img/product1@3x.png" alt="">');
            }
        })();

        //seven
        ;(function() {
            $("#honor").html(data.honorary);
            if (data.honoraryType == "A") {
                $(".honorImg").append('<img src="activity/img/medal1@3x.png" alt="">');
            } else if (data.honoraryType == "B") {
                $(".honorImg").append('<img src="activity/img/medal2@3x.png" alt="">');
            } else if (data.honoraryType == "C") {
                $(".honorImg").append('<img src="activity/img/medal3@3x.png" alt="">');
            } else if (data.honoraryType == "D") {
                $(".honorImg").append('<img src="activity/img/medal4@3x.png" alt="">');
            } else {
                $(".honorImg").append('<img src="activity/img/medal5@3x.png" alt="">');
            }
        })();

        $(".money").html(data.redPacket);
        //         $("#openRed").on('click touch', function () {
        //             top.location.href = endYearUserReward+'?uid=' + $("#uid").val(); //TODO
        //         });
        //         $("#btnRank").on('click touch', function () {
        //             top.location.href = rankingpage+'?uid=' + $("#uid").val(); //TODO
        //         })
    } else {
        mySwiper.removeSlide([2, 3, 4, 5, 6, 7, 8, 9, 10]);
    }
    
    $(".bingo").after('<div class="littlestar"><img src="activity/img/littlestar@3x.png" alt = ""/></div><div class="littlestar1"><img src="activity/img/littlestar1@3x.png" alt=""/></div><div class="littlestar2"><img src="activity/img/littlestar2@3x.png" alt=""/></div>');
});