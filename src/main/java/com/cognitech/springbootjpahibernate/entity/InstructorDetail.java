package com.cognitech.springbootjpahibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity class for Instructor Detail
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    //---------------------------------------------------------------------------------------------
    public InstructorDetail()
    {
    }

    public InstructorDetail(String youtubeChannel, String hobby)
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    //---------------------------------------------------------------------------------------------
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getYoutubeChannel()
    {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel)
    {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
