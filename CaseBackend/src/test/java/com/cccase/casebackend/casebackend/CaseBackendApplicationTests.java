package com.cccase.casebackend.casebackend;

import com.cccase.casebackend.pojo.vo.PartitionVo;
import com.cccase.casebackend.service.PartitionService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.cccase.casebackend.mapper")
class CaseBackendApplicationTests {



    @Test
    void contextLoads(@Autowired PartitionService partitionService) {
        List<PartitionVo> partition = partitionService.getPartition();

    }

}
