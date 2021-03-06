/**
 * This file was generated by the Jeddict
 */
package com.parkhomenko.product;

import com.parkhomenko.common.Translation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dmytro
 */

@NoArgsConstructor
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String shortDescription;

    @Lob
    @Basic
    private byte[] image;

    @Basic
    private boolean isAvailable;

    @Basic
    private int goodsCount;

    @Basic
    private int position;

    @OneToOne(targetEntity = SeoAttribute.class)
    private SeoAttribute seoAttribute;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    @OneToMany(targetEntity = Translation.class)
    @JoinColumn(name = "CATEGORY_ID")
    private List<Translation> translations;

    public void addTranslation(Translation translation) {
        getTranslations().add(translation);
    }

    public void removeTranslation(Translation translation) {
        getTranslations().remove(translation);
    }

}