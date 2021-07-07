package util;

import com.hit.util.CLI;

import java.io.IOException;

public interface IObserver {
    void propertyChange(CLI cli) throws IOException;
}
