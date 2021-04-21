package me.xueyao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Simon.Xue
 * @date 2021/4/8 3:28 下午
 **/
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", columnDefinition = "varchar(32) not null comment '用户名'")
    private String username;
    @Column(name = "password", columnDefinition = "varchar(64) not null comment '密码'")
    private String password;
    @Column(name = "nickname", columnDefinition = "varchar(32) not null default '' comment '昵称'")
    private String nickname;

    @Column(name = "removed", columnDefinition = "bit(1) default 0 comment '是否删除 0未删除 1删除'")
    private Boolean removed = false;
    @Column(name = "creator", columnDefinition = "varchar(64) not null comment '创建者'")
    private String creator;
    @Column(name = "updater", columnDefinition = "varchar(64) comment '更新者'")
    private String updater;
    @Column(name = "create_time", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createTime;
    @Column(name = "update_time", columnDefinition = "timestamp default current_timestamp on update current_timestamp comment '更新时间'")
    private Date updateTime;

}
