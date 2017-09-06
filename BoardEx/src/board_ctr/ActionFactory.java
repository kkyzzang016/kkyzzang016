package board_ctr;

import board_ctr.action.Action;
import board_ctr.action.BoardCheckPassAction;
import board_ctr.action.BoardCheckPassFormAction;
import board_ctr.action.BoardDeleteAction;
import board_ctr.action.BoardListAction;
import board_ctr.action.BoardUpdateAction;
import board_ctr.action.BoardUpdateFormAction;
import board_ctr.action.BoardViewAction;
import board_ctr.action.BoardWriteAction;
import board_ctr.action.BoardWriteFormAction;

public class ActionFactory {
   private static ActionFactory instance = new ActionFactory();
   
   private ActionFactory() {
      super();
   }
   
   public static ActionFactory getInstance() {
      return instance;
   }
   
   public Action getAction(String command) {
      Action action = null;
      System.out.println("ActionFactory : " + command);
      /* �߰��� �κ� */
      if(command.equals("board_list")) {
         action = new BoardListAction();
      }else if(command.equals("board_write_form")) {
         action = new BoardWriteFormAction();
      }else if(command.equals("board_write")) {
         action = new BoardWriteAction();
      }else if(command.equals("board_view")) {
         action = new BoardViewAction();
      }else if(command.equals("board_check_pass_form")) {
         action = new BoardCheckPassFormAction();
      }else if(command.equals("board_check_pass")) {
         action = new BoardCheckPassAction();
      }else if(command.equals("board_update_form")) {
         action = new BoardUpdateFormAction();
      }else if(command.equals("board_update")){
         action = new BoardUpdateAction();
      }else if(command.equals("board_delete")) {
         action = new BoardDeleteAction();
      }
      return action;
   }
      
}