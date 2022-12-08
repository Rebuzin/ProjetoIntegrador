package com.example.appmedia.mapper;

import com.example.appmedia.model.Veiculo;
import com.example.appmedia.ormlite.VeiculoOrmLite;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VeiculoMapperOrmLite {

    Veiculo ormToVo(VeiculoOrmLite ormLite);

    VeiculoOrmLite voToOrm(Veiculo vo);

    List<Veiculo> listOrmToListVo(List<VeiculoOrmLite> ormLite);

    List<VeiculoOrmLite> listVoToListOrm(List<Veiculo> vo);

}
