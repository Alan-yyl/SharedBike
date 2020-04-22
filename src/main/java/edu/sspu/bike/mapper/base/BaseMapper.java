package edu.sspu.bike.mapper.base;

/**
 * @auther 杨亚龙
 * @date 2019/11/4 17:08
 */
public interface BaseMapper<T> {
    T findById(String id);
    T findByid(int id);
    T findByIdAndPassword(T t);
}
