package com.smile.mapper;

import com.smile.pojo.Email;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午11:00
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface RedisMapper {
    public void set(Email email);
    public String get(String email);
    public boolean hasKey(String key);


}
