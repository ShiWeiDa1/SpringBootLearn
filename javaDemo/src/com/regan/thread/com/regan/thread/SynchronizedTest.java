package com.regan.thread.com.regan.thread;

import com.regan.thread.com.regan.model.DistributeSeqNumDTO;
import com.regan.thread.com.regan.model.ThirdSaveBatch;
import com.regan.thread.com.regan.model.ThirdTagSeqNumsDTO;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 *@className: SynchronizedTest
 *@description:
 *@author: Regan
 *@date: 2020/11/1 15:31
 *@version: V1.0
 **/
public class SynchronizedTest {

    public void testSynchronized() {

    }

    public static Integer seq = 0;

    static {
        ThirdSaveBatch thirdSaveBatchRepository = new ThirdSaveBatch();
        thirdSaveBatchRepository.setEseConfigId(11L);
        thirdSaveBatchRepository.setEseId(11L);
        thirdSaveBatchRepository.setSeqnumCurrent(1L);
        thirdSaveBatchRepository.setSeqnumStart(1L);
        thirdSaveBatchRepository.setSeqnumEnd(100L);
        thirdSaveBatchRepository.setEseSeqnumEnd(100L);
        thirdSaveBatchRepository.setEseSeqnumStart(1L);
    }


    private ThirdTagSeqNumsDTO getThirdSaveBatchSync(DistributeSeqNumDTO distributeSeqNumDTO) {

        synchronized (ThirdTagSeqNumsDTO.class) {

            ThirdSaveBatch thirdSaveBatch = new ThirdSaveBatch();
            thirdSaveBatch.setEseConfigId(11L);
            thirdSaveBatch.setEseId(11L);
            thirdSaveBatch.setSeqnumCurrent(1L);
            thirdSaveBatch.setSeqnumStart(1L);
            thirdSaveBatch.setSeqnumEnd(100L);
            thirdSaveBatch.setEseSeqnumEnd(100L);
            thirdSaveBatch.setEseSeqnumStart(1L);
            ThirdTagSeqNumsDTO thirdTagSeqNumsDTO = null;
            Integer seqCount = distributeSeqNumDTO.getSeqCount();
            if (thirdSaveBatch == null || thirdSaveBatch.getSeqnumCurrent() + seqCount > thirdSaveBatch.getSeqnumEnd()) {

                if (thirdSaveBatch != null) {
                    thirdSaveBatch.setOver(true);
                    //thirdSaveBatchRepository.save(thirdSaveBatch);
                }

                thirdSaveBatch = new ThirdSaveBatch();
                thirdSaveBatch.setEseId(distributeSeqNumDTO.getEseId());
                thirdSaveBatch.setUri(distributeSeqNumDTO.getUri());

                distributeSeqNumDTO.setSeqCount(1000000);
                distributeSeqNumDTO.setTotalCount(1000000);
                //thirdTagSeqNumsDTO = codeClient.distributeSeqNums(distributeSeqNumDTO);
                BeanUtils.copyProperties(thirdTagSeqNumsDTO, thirdSaveBatch);
                thirdSaveBatch.setSeqnumCurrent(thirdSaveBatch.getSeqnumStart());
                //thirdSaveBatchRepository.save(thirdSaveBatch);
            } else {
                thirdTagSeqNumsDTO = new ThirdTagSeqNumsDTO();
                BeanUtils.copyProperties(thirdSaveBatch, thirdTagSeqNumsDTO);
            }

            thirdTagSeqNumsDTO.setSeqnumStart(thirdSaveBatch.getSeqnumCurrent());
            thirdTagSeqNumsDTO.setSeqnumEnd(thirdSaveBatch.getSeqnumCurrent() + seqCount - 1);
            thirdTagSeqNumsDTO.setEseSeqnumStart(
                    thirdSaveBatch.getEseSeqnumStart() + thirdSaveBatch.getSeqnumCurrent() - thirdSaveBatch.getSeqnumStart());
            thirdTagSeqNumsDTO.setEseSeqnumEnd(thirdSaveBatch.getEseSeqnumStart() + seqCount + thirdSaveBatch.getSeqnumCurrent()
                    - thirdSaveBatch.getSeqnumStart() - 1);

            thirdSaveBatch.setSeqnumCurrent(thirdSaveBatch.getSeqnumCurrent() + seqCount);
            //thirdSaveBatchRepository.save(thirdSaveBatch);
            System.out.println(thirdTagSeqNumsDTO);
            return thirdTagSeqNumsDTO;
        }
    }


    private ThirdSaveBatch initData(ThirdSaveBatch thirdSaveBatch) {
        if (Objects.isNull(thirdSaveBatch)) {
            ThirdSaveBatch thirdSaveBatchInit = new ThirdSaveBatch();
            thirdSaveBatch.setEseConfigId(11L);
            thirdSaveBatch.setEseId(11L);
            thirdSaveBatch.setSeqnumCurrent(1L);
            thirdSaveBatch.setSeqnumStart(1L);
            thirdSaveBatch.setSeqnumEnd(100L);
            thirdSaveBatch.setEseSeqnumEnd(100L);
            thirdSaveBatch.setEseSeqnumStart(1L);
            return thirdSaveBatchInit;
        }

        return thirdSaveBatch;

    }

    private void getThirdSaveBatch() {
        seq++;
        System.out.println(seq);
    }

    private void getThirdSaveBatchSync2(DistributeSeqNumDTO distributeSeqNumDTO) {
        synchronized (ThirdTagSeqNumsDTO.class) {
            ThirdTagSeqNumsDTO thirdTagSeqNumsDTO = null;
            Integer seqCount = distributeSeqNumDTO.getSeqCount();
            //seqCount
        }
        System.out.println(seq);
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        DistributeSeqNumDTO distributeSeqNumDTO = new DistributeSeqNumDTO();
        for (int i = 0; i < 100; i++) {
            //CompletableFuture.runAsync(() -> synchronizedTest.getThirdSaveBatchSync2());
        }
        while (true) {

        }
    }

}
