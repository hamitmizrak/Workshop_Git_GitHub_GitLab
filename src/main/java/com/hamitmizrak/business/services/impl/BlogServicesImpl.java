package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.services.IBlogServices;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.repository.IBlogRepository;
import com.hamitmizrak.exception.HamitMizrakException;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity> {

    // Injection (Lombok Constructor Field) => 3.YOL
    private final IBlogRepository iBlogRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return modelMapperBean.modelMapperMethod().map(blogEntity,BlogDto.class);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        return  modelMapperBean.modelMapperMethod().map(blogDto,BlogEntity.class);
    }

    // CREATE
    @Override
    @Transactional // create, delete, update
    public BlogDto  blogServiceCreate(BlogDto blogDto) {
        if(blogDto!=null){
            BlogEntity blogEntity=dtoToEntity(blogDto);
            iBlogRepository.save(blogEntity);
            blogDto.setId(blogEntity.getBlogId());
            blogDto.setSystemDate(blogEntity.getBlogEntityEmbeddable().getSystemDate());
        }else{
            throw  new NullPointerException( " blogdto null veri");
        }
        return blogDto;
    }

    // LIST
    @Override
    public List<BlogDto>  blogServiceList() {
        Iterable<BlogEntity> entityIterable=  iBlogRepository.findAll();
        // Dto To entityb List
        List<BlogDto> categoryDtoList=new ArrayList<>();
        for (BlogEntity entity:  entityIterable) {
            BlogDto blogDto=entityToDto(entity);
            categoryDtoList.add(blogDto);
        }
        log.info("Liste Sayısı: "+categoryDtoList.size());
        return categoryDtoList;
    }

    // FIND
    @Override
    public BlogDto  blogServiceFindById(Long id) {
        // 1.YOL (FIND)
        /*
        Optional<BlogEntity> findOptionalBlogEntity=  iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDto(findOptionalBlogEntity.get());
        if(findOptionalBlogEntity.isPresent()){
            return categoryDto;
        }
        */

        // 2.YOL (FIND)
        BlogEntity findBlogEntity=  null;
        if(id!=null){
            findBlogEntity=  iBlogRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException(id+" nolu id yoktur"));
        }else if(id==null) {
            throw new HamitMizrakException("İd null olarak geldi");
        }
        return entityToDto(findBlogEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public BlogDto  blogServiceUpdate(Long id, BlogDto blogDto) {
        // Önce Bul
        BlogDto blogFindDto= blogServiceFindById(id);
       if(blogFindDto!=null){
           BlogEntity blogEntity=dtoToEntity(blogFindDto);
           blogEntity.getBlogEntityEmbeddable().setTitle(blogDto.getTitle());
           blogEntity.getBlogEntityEmbeddable().setHeader(blogDto.getHeader());
           blogEntity.getBlogEntityEmbeddable().setContent(blogDto.getContent());
           iBlogRepository.save(blogEntity);
           // Dönüştede ID ve Date Set et
       }
        return blogDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public BlogDto blogServiceDeleteById(Long id) {
        // Önce Bul
        BlogDto categoryFindDto= blogServiceFindById(id);
        if(categoryFindDto!=null){
            iBlogRepository.deleteById(id);
            // Dönüştede ID ve Date Set et
        }
        return categoryFindDto;
    }

} //end class
