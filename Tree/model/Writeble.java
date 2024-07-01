package model;

import java.io.Serializable;

public interface Writeble {
    void save(Serializable serializable);

    Object read();
}
