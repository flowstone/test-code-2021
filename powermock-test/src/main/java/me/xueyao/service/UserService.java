package me.xueyao.service;

import me.xueyao.base.R;
import me.xueyao.entity.User;

/**
 * @author Simon.Xue
 * @date 2021/4/8 3:34 下午
 **/
public interface UserService {

    /**
     * 插入
     * @param user
     * @return
     */
    R insert(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    R update(User user);

    /**
     * 查询详情
     * @param id
     * @return
     */
    R getById(Integer id);

    /**
     * 查询列表
     * @return
     */
    R findList();
}
