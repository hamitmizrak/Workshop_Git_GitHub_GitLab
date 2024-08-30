package com.hamitmizrak.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter @Setter
abstract  public class AuditingAwareBaseDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    private Long id;

    // DATE
    @Builder.Default
    private Date systemDate=new Date(System.currentTimeMillis());

    // AUDTING
    // @JsonIgnore => Backentte veri giderken bu bilgiyi gösterme
    // KIM EKLEDİ ?
    @JsonIgnore
    protected String createdUser;

    // KİM NE ZAMAN EKLEDİ ?
    @JsonIgnore
    protected Date createdDate;

    // KIM GÜNCELLEDİ ?
    protected String updatedUser;

    // KİM NE ZAMAN GÜNCELLEDİ ?
    protected Date updatedDate;
}
