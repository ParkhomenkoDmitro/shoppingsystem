/**
 * This file was generated by the Jeddict
 */
package com.parkhomenko.product;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dmytro
 */

@NoArgsConstructor
@Data
@Entity
@Table(name = "SEO_ATTRIBUTE")
public class SeoAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String description;

    @Basic
    private String keywords;
}