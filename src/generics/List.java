package generics;

import java.util.Collection;

public interface List<B> extends Collection<B> {
    B get (int index);
}
