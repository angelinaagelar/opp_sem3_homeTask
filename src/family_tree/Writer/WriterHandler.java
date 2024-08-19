package family_tree.Writer;

import java.io.Serializable;

public interface WriterHandler {
    boolean save(Serializable serializable);
    Object read();
}

