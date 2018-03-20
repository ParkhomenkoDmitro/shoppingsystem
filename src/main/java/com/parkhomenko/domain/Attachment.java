/**
 * This file was generated by the Jeddict
 */
package com.parkhomenko.domain;

import com.parkhomenko.product.FileType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * @author dmytro
 */
@Entity
@Table(name = "ATTACHMENT")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @NotNull
    private byte @NotNull [] file;

    @Column(nullable = false)
    @Basic
    @Enumerated(EnumType.STRING)
    @NotNull
    private FileType type;

    @Column(nullable = false)
    @Basic
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Column(unique = true)
    @Basic
    @PositiveOrZero
    private byte position;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return this.file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public FileType getType() {
        return this.type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getPosition() {
        return this.position;
    }

    public void setPosition(byte position) {
        this.position = position;
    }

}