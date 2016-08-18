
public class ErrorHandle {

		public static void handle(String err_msg, Exception e, ErrorType type)
		{
			String errorTypeString = type.name();
			boolean exit_status; 	//error causes system exit if True, not if False
			int exit_no;		//integer to pass to System.exit()
			
			switch (type)
			{
				case FATAL:
					exit_status = true;
					exit_no = -1;
					break;
				case WARNING:
					exit_status = false;
					exit_no = 0;
					break;
				default:
					exit_status = false;
					exit_no = 0;
			}
			System.out.printf("Error [%s]: %s\n",errorTypeString,err_msg);
			System.out.printf("<Raw error message>: %s",e.getMessage());
			if (exit_status)
			{
				System.exit(exit_no);
			}
		}
}
