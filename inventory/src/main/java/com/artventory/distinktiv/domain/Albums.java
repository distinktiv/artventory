package com.artventory.distinktiv.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by distinktiv on 2017-01-29.
 */
@Entity
public class Albums implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int year;

    @Column
    private int startingSequenceNumber;


}
