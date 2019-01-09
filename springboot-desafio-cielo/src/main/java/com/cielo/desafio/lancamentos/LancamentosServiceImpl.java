package com.cielo.desafio.lancamentos;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class LancamentosServiceImpl implements LancamentosService{

    @Override
    public String obterLancamentos() throws IOException {
        Resource resource =  new ClassPathResource("lancamento-conta-legado.json");
        byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(data, StandardCharsets.UTF_8);
    }
}
