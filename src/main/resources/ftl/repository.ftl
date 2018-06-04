package ${ package }.organization.repository;

import ${ package }.organization.entity.${className};
import org.springframework.data.jpa.repository.JpaRepository;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>

public interface ${className}Repository extends JpaRepository<${className},Long> {

}