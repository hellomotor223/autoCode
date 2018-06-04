package ${ package }.organization.service;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>

public interface ${ className }Service {
	
	List<${ className }> findAll();

    List<${ className }> findByPage(${ className } ${ className?uncap_first },int page,int count);

    ${ className } findOne(Long id);

    ${ className } findOne(${ className } ${ className?uncap_first });

    void save(${ className } ${ className?uncap_first });

    void delete(Long id);
    
}
