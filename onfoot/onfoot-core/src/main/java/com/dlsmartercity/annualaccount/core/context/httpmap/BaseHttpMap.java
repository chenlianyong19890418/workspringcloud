package com.dlsmartercity.annualaccount.core.context.httpmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public abstract class BaseHttpMap implements Map<Object, Object> {

	@Override
	public int size() {
		return keySet().size();
	}

	@Override
	public boolean isEmpty() {
		return keySet().size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return keySet().contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return values().contains(value);
	}

	@Override
	public Object get(Object key) {
		return getValue(key);
	}

	@Override
	public Object put(Object key, Object value) {
		Object old = getValue(key);
		putValue(key, value);
		return old;
	}

	@Override
	public Object remove(Object key) {
		Object old = getValue(key);
		removeValue(key);
		return old;
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> map) {
		Iterator<Object> i = (Iterator<Object>) map.keySet().iterator();
		while (i.hasNext()) {
			Object key = i.next();
			putValue(key, map.get(key));
		}
	}

	@Override
	public void clear() {
		Iterator<Object> i = keySet().iterator();
		while (i.hasNext()) {
			removeValue(i.next());
		}
	}

	@Override
	public Set<Object> keySet() {
		Set<Object> keySet = new HashSet<>();
		Enumeration<Object> enumeration = (Enumeration<Object>) getNames();
		while (enumeration.hasMoreElements()) {
			keySet.add(enumeration.nextElement());
		}
		return keySet;
	}

	@Override
	public Collection<Object> values() {
		List<Object> list = new ArrayList<Object>();
		Enumeration<Object> enumeration = (Enumeration<Object>) getNames();
		while (enumeration.hasMoreElements()) {
			list.add(getValue(enumeration.nextElement()));
		}
		return list;
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		return new HashSet<java.util.Map.Entry<Object, Object>>();
	}

	protected abstract Enumeration<? extends Object> getNames();

	protected abstract Object getValue(Object key);

	protected abstract void putValue(Object key, Object value);

	protected abstract void removeValue(Object key);

}
