package com.manchey.service.impl;

import com.manchey.dao.impl.SimpleBean;
import com.manchey.service.OxmExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Service;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ray on 2016/5/27.
 */
@Service("oxmExampleService")
public class OxmExampleServiceImpl implements OxmExampleService {

    private static final String FILE_NAME = "simplebean.xml";

    private Marshaller marshaller;

    private Unmarshaller unmarshaller;
    private SimpleBean simpleBean;

    @Autowired
    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    @Autowired
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @Autowired
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }


    @Override
    public void saveSimpleBean() throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(FILE_NAME);
            this.marshaller.marshal(simpleBean, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @Override
    public void loadSimpleBean() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(FILE_NAME);
            this.simpleBean = (SimpleBean) this.unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
