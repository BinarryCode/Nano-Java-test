package javax.bluetooth;
import java.io.IOException;
public class BluetoothConnectionException extends IOException
{
	BluetoothConnectionException()
	{
		super();
	}
	BluetoothConnectionException(String s)
	{
		super(s);
	}
}