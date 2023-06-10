package com.devStack.pos.entity.process;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class FileResource {
    @Column(columnDefinition = "LONGBLOB")
    private Blob fileName;

    @Column(columnDefinition = "LONGBLOB")
    private Blob resourceURL;

    @Column(columnDefinition = "LONGBLOB")
    private Blob directory;

    @Column(columnDefinition = "LONGBLOB")
    private Blob hash;
}
