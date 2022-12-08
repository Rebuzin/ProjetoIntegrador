package com.example.appmedia.mapper;

import com.example.appmedia.model.Motorista;
import com.example.appmedia.ormlite.MotoristaOrmLite;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MotoristaMapperOrmLite {

    Motorista ormToVo(MotoristaOrmLite ormLite);

    MotoristaOrmLite voToOrm(Motorista vo);

    List<Motorista> listOrmToListVo(List<MotoristaOrmLite> ormLite);

    List<MotoristaOrmLite> listVoToListOrm(List<Motorista> vo);

}
