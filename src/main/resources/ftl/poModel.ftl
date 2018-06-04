package ${ package }.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

<#import "CopyRight.ftl" as my>
<@my.CopyRight/>
@Entity
@Data
@ApiModel(value = "${ className }",description = "${comment}数据结构")
@Table(name="${tableName}")
public class ${ className } implements Serializable {
	private static final long serialVersionUID = 1L;

<#list properties as pro>  
	<#if pro.primary>
	@Id
	@Column(name = "${pro.fieldName}")
	@ApiModelProperty(value = "${pro.proComment}")
	private ${pro.proType} ${pro.proName};	<#-- 代码规范：数据库表主键映射成id -->  	
	<#else>
	@Column(name = "${pro.fieldName}")
	@ApiModelProperty(value = "${pro.proComment}")
	private ${pro.proType} ${pro.proName};
	</#if>
</#list>

}
