package com.shuonai.gm.service;

import com.shuonai.gm.domain.Api;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IApiService {
    public int insertApi(Api api);

    public int updateApi(Api api);

    public int deleteApi(int id);

    public Api getApi(int id);

    public int getSeq();

    public int updateSeq(int row);
    public List<Api> getApiList();
}