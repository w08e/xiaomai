package com.w08e.xiaomai.common.result;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;

/**
 * @author jinyuewang
 */
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    protected OffsetDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    protected OffsetDateTime modifyTime;

    /**
     * 乐观锁版本
     * */
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    /**
     * 删除标识
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 启用状态
     */
    @Column(name = "status")
    private Integer status;


    public BaseEntity() {
        createTime = OffsetDateTime.now();
        modifyTime = createTime;
        isDeleted = false;
        status = 1;
    }

    public boolean isDelete() {
        return isDeleted != null && isDeleted;
    }

    public void del() {
        this.isDeleted = true;
    }

    public Integer getVersion() {
        return version;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public OffsetDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(OffsetDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
