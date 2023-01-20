package org.opendata.madrid.services;

import java.util.List;

public interface Transform<E> {

	List<E> toObject(String[] line);
}
