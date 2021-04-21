package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.entity.User;
import me.xueyao.repository.UserRepository;
import me.xueyao.service.UserService;
import me.xueyao.utils.BeanCompareUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2021/4/8 3:34 下午
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public R insert(User user) {
        return R.ofSuccess("成功", userRepository.save(user));
    }

    @Override
    public R update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (!optionalUser.isPresent()) {
            return R.ofParam("失败");
        }
        User userInfo = optionalUser.get();
        BeanUtils.copyProperties(user, userInfo, BeanCompareUtils.getEmptyPropertyNames(user));

        return R.ofSuccess("成功", userRepository.save(userInfo));
    }

    @Override
    public R getById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return R.ofParam("失败");
        }
        return R.ofSuccess("成功", optionalUser.get());
    }

    @Override
    public R findList() {
        List<User> all = userRepository.findAll();
        return R.ofSuccess("成功", all);
    }
}
