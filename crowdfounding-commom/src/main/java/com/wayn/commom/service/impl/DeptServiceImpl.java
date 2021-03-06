package com.wayn.commom.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wayn.commom.dao.DeptDao;
import com.wayn.commom.domain.Dept;
import com.wayn.commom.util.TreeBuilderUtil;
import com.wayn.commom.domain.vo.Tree;
import com.wayn.commom.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wayn
 * @since 2019-04-13
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @CacheEvict(value = "deptCache", allEntries = true)
    @Override
    public boolean save(Dept dept) {
        dept.setCreateTime(new Date());
        return insert(dept);
    }

    @CacheEvict(value = "deptCache", allEntries = true)
    @Override
    public boolean update(Dept dept) {
        return updateById(dept);
    }

    @CacheEvict(value = "deptCache", allEntries = true)
    @Override
    public boolean remove(Long id) {
        return deleteById(id);
    }

    @Cacheable(value = "deptCache", key = "#root.method  + '_dept'")
    @Override
    public Tree<Dept> getTree() {
        List<Tree<Dept>> trees = new ArrayList<>();
        List<Dept> menus = deptDao.selectList(new EntityWrapper<>());
        menus.forEach(menu -> {
            Tree<Dept> tree = new Tree<>();
            tree.setId(menu.getId().toString());
            tree.setParentId(menu.getPid().toString());
            tree.setText(menu.getDeptName());
            trees.add(tree);
        });
        return TreeBuilderUtil.build(trees);
    }

    @Override
    public List<Long> listChildrenIds(Long pid) {
        List<Dept> list = deptDao.selectList(new EntityWrapper<Dept>());
        return treeDept(list, pid);
    }

    public List<Long> treeDept(List<Dept> list, Long pid) {
        List<Long> deptIds = new ArrayList<Long>();
        deptIds.add(pid);
        list.forEach(dept -> {
            if (pid == dept.getPid()) {
                deptIds.addAll(treeDept(list, dept.getId()));
                deptIds.add(dept.getId());
            }
        });
        return deptIds;
    }

    @Cacheable(value = "deptCache", key = "#root.method  + '_' + #root.args[0]")
    @Override
    public List<Dept> list(Dept dept) {
        EntityWrapper<Dept> wrapper = new EntityWrapper<Dept>();
        wrapper.like("deptName", dept.getDeptName());
        return selectList(wrapper.orderBy("sort"));
    }

}
