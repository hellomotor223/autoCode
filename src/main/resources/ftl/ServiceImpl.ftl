package ${ package }.service.impl;

import ${ package }.entity.CompanyDept;
import ${ package }.repository.CompanyDeptRepository;
import ${ package }.service.ICompanyDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>
@Service
public class ${ className }ServiceImpl  implements ${ className }Service{

    @Autowired
    private ${ className }Repository ${ className?uncap_first }Dao;
    @Override
    public List<${ className }> findAll() {
        return ${ className?uncap_first }Dao.findAll();
    }

    @Override
    public Page<${ className }> findByPage(${ className } companyDept, int page, int count) {
        PageRequest pageRequest = new PageRequest(page, count);
        return ${ className?uncap_first }Dao.findAll(pageRequest);
    }

    @Override
    public ${ className } findOne(Long id) {
        return ${ className?uncap_first }Dao.findOne(id);
    }

    @Override
    public ${ className } findOne(${ className } ${ className?uncap_first }) {
        Example<${ className }> ${ className?uncap_first }Example = Example.of(${ className?uncap_first });
        return ${ className?uncap_first }.findOne(${ className?uncap_first }Example);
    }

    @Override
    public void save(${ className } ${ className?uncap_first }) {
        companyDeptDao.save(${ className?uncap_first });
    }

    @Override
    public void delete(Long id) {
        companyDeptDao.delete(id);
    }


}
