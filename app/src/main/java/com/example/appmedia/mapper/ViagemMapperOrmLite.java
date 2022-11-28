package com.example.appmedia.mapper;

import com.example.appmedia.model.Viagem;
import com.example.appmedia.ormlite.ViagemOrmLite;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ViagemMapperOrmLite {

    Viagem ormToVo(ViagemOrmLite ormLite);

    ViagemOrmLite voToOrm(Viagem vo);

    List<Viagem> listOrmToListVo(List<ViagemOrmLite> ormLite);

    List<ViagemOrmLite> listVoToListOrm(List<Viagem> vo);

}
