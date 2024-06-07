package model;

import java.io.Serializable;

public interface Writeble {
    boolean save(Serializable serializable, String filePyt);

    Object read(String filePyt);
}
