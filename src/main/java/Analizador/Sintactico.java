
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizador;

import java_cup.runtime.*;
import java.util.ArrayList;
import Principal.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\031\000\002\002\004\000\002\002\003\000\002\003" +
    "\005\000\002\004\007\000\002\005\004\000\002\005\003" +
    "\000\002\007\004\000\002\007\003\000\002\006\004\000" +
    "\002\006\003\000\002\010\010\000\002\011\006\000\002" +
    "\012\006\000\002\013\003\000\002\013\003\000\002\014" +
    "\004\000\002\014\005\000\002\014\005\000\002\014\004" +
    "\000\002\014\004\000\002\014\003\000\002\014\003\000" +
    "\002\014\003\000\002\014\003\000\002\014\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\004\006\006\001\002\000\004\002\000\001" +
    "\002\000\004\002\065\001\002\000\004\005\011\001\002" +
    "\000\006\005\011\024\025\001\002\000\006\005\ufffc\024" +
    "\ufffc\001\002\000\004\007\014\001\002\000\004\023\013" +
    "\001\002\000\004\002\uffff\001\002\000\004\024\015\001" +
    "\002\000\004\010\016\001\002\000\006\025\017\026\020" +
    "\001\002\000\004\004\ufff3\001\002\000\004\004\ufff4\001" +
    "\002\000\004\004\022\001\002\000\006\005\ufff7\024\ufff7" +
    "\001\002\000\006\005\ufffd\024\ufffd\001\002\000\006\011" +
    "\053\024\025\001\002\000\004\010\027\001\002\000\006" +
    "\011\ufffa\024\ufffa\001\002\000\026\013\041\014\034\015" +
    "\037\016\032\017\042\020\036\021\040\022\035\027\030" +
    "\030\031\001\002\000\030\004\uffea\013\uffea\014\uffea\015" +
    "\uffea\016\uffea\017\uffea\020\uffea\021\uffea\022\uffea\027\uffea" +
    "\030\uffea\001\002\000\030\004\uffe9\013\uffe9\014\uffe9\015" +
    "\uffe9\016\uffe9\017\uffe9\020\uffe9\021\uffe9\022\uffe9\027\uffe9" +
    "\030\uffe9\001\002\000\026\013\041\014\034\015\037\016" +
    "\032\017\042\020\036\021\040\022\035\027\030\030\031" +
    "\001\002\000\004\004\051\001\002\000\026\013\041\014" +
    "\034\015\037\016\032\017\042\020\036\021\040\022\035" +
    "\027\030\030\031\001\002\000\030\004\uffeb\013\uffeb\014" +
    "\uffeb\015\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\022\uffeb" +
    "\027\uffeb\030\uffeb\001\002\000\030\004\uffed\013\uffed\014" +
    "\uffed\015\uffed\016\uffed\017\uffed\020\uffed\021\uffed\022\uffed" +
    "\027\uffed\030\uffed\001\002\000\026\013\041\014\034\015" +
    "\037\016\032\017\042\020\036\021\040\022\035\027\030" +
    "\030\031\001\002\000\030\004\uffec\013\uffec\014\uffec\015" +
    "\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022\uffec\027\uffec" +
    "\030\uffec\001\002\000\026\013\041\014\034\015\037\016" +
    "\032\017\042\020\036\021\040\022\035\027\030\030\031" +
    "\001\002\000\026\013\041\014\034\015\037\016\032\017" +
    "\042\020\036\021\040\022\035\027\030\030\031\001\002" +
    "\000\030\004\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017" +
    "\uffee\020\uffee\021\uffee\022\uffee\027\uffee\030\uffee\001\002" +
    "\000\026\013\041\014\034\015\037\016\032\017\042\020" +
    "\036\021\040\022\035\027\030\030\031\001\002\000\030" +
    "\004\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020" +
    "\ufff1\021\ufff1\022\ufff1\027\ufff1\030\ufff1\001\002\000\030" +
    "\004\ufff2\013\ufff2\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020" +
    "\ufff2\021\ufff2\022\ufff2\027\ufff2\030\ufff2\001\002\000\026" +
    "\013\041\014\034\015\037\016\032\017\042\020\036\021" +
    "\040\022\035\027\030\030\031\001\002\000\030\004\ufff0" +
    "\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021" +
    "\ufff0\022\ufff0\027\ufff0\030\ufff0\001\002\000\006\011\ufff6" +
    "\024\ufff6\001\002\000\030\004\uffef\013\uffef\014\uffef\015" +
    "\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef\027\uffef" +
    "\030\uffef\001\002\000\004\011\055\001\002\000\006\011" +
    "\ufffb\024\ufffb\001\002\000\004\024\056\001\002\000\004" +
    "\007\062\001\002\000\006\023\ufffe\024\056\001\002\000" +
    "\006\023\ufff8\024\ufff8\001\002\000\006\023\ufff9\024\ufff9" +
    "\001\002\000\004\027\063\001\002\000\004\004\064\001" +
    "\002\000\006\023\ufff5\024\ufff5\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\006\002\004\003\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\004\011\005\006\010\007" +
    "\001\001\000\010\007\023\010\022\011\025\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\013" +
    "\020\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\053\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\014\032\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\014\051\001\001\000\002\001\001\000\004\014\046" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\014" +
    "\045\001\001\000\002\001\001\000\004\014\043\001\001" +
    "\000\004\014\042\001\001\000\002\001\001\000\004\014" +
    "\044\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\014\047\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\006\056\012\057\001\001\000\002\001\001\000\004\012" +
    "\060\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    /*
    clase nodo que va a tener lista de siguientes, lista de ultimos, si es hoja, el lexema, el tipo
clase arbol que va a tener nodo izquierdo y derecho y que va a actuar como ramificacion
clase expresion que va a guardar el arbol, y el identificador de la expresion
clae conjunto que va a guardar el nombre del conjunto, la lista de conjuntos y ya creo xD

*/


    public ArrayList<Expresion> Expresiones= new ArrayList<>();
    public ArrayList<Nodo> listaNodos= new ArrayList<>();
Expresion exp;
  public void errorSintactico(Symbol s){
      System.out.println("Error Sintactico en linea: "+s.left+ " Columna: "+s.right+" Error: "+s.value+" "+s.sym);
    }
  
  public void errorIrrecuperable(Symbol s) throws java.lang.Exception{
      System.out.println("Error sintactico sin posibilidad a reparacion en la linea: "+s.left+" Columna: "+s.right+" Error: "+s.value+" nno reconocido");
  }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {
  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ini ::= instrucciones 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // instrucciones ::= LLAVEABIERTA contenido LLAVECERRADA 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // contenido ::= conjuntos expresiones SEPARADOR SEPARADOR validaciones 
            {
              ArrayList RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("contenido",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // conjuntos ::= conjuntos conjunto 
            {
              ArrayList RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("conjuntos",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // conjuntos ::= conjunto 
            {
              ArrayList RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("conjuntos",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expresiones ::= expresiones expresion 
            {
              ArrayList RESULT =null;
		listaNodos=new ArrayList<>();
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresiones",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresiones ::= expresion 
            {
              ArrayList RESULT =null;
		listaNodos=new ArrayList<>();
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresiones",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // validaciones ::= validaciones validacion 
            {
              ArrayList RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("validaciones",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // validaciones ::= validacion 
            {
              ArrayList RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("validaciones",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // conjunto ::= RESCONJ DOSPUNTOS IDENTIFICADOR ASIGNADOR tipoConjunto PTCOMA 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("conjunto",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion ::= IDENTIFICADOR ASIGNADOR expReg PTCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		ArrayList b = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		Expresiones.add(new Expresion(a,listaNodos));System.out.println(Expresiones.get(0).getListaNodos().get(0).getLexema());main.principio.getListaExpresiones().add(new Expresion(a,listaNodos));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // validacion ::= IDENTIFICADOR DOSPUNTOS CADENA PTCOMA 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("validacion",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // tipoConjunto ::= CONJCOMAS 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("tipoConjunto",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // tipoConjunto ::= CONJCAR 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("tipoConjunto",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expReg ::= CERRADURAKLEENE expReg 
            {
              ArrayList RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ArrayList e1 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= e1;RESULT.add(new Nodo("*","CERRADKLN"));listaNodos.add(new Nodo(a,"CERRADKLN"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expReg ::= CONCATENACION expReg expReg 
            {
              ArrayList RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		ArrayList e1 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ArrayList e2 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= e1; RESULT.addAll(e2);RESULT.add(new Nodo(".","CONCA"));listaNodos.add(new Nodo(a,"CONCA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expReg ::= DISYUNCION expReg expReg 
            {
              ArrayList RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		ArrayList e1 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ArrayList e2 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= e1; RESULT.addAll(e2);RESULT.add(new Nodo("|","DISYUNC"));listaNodos.add(new Nodo("|","DISYUNC"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expReg ::= CERRADURAPOSITIVA expReg 
            {
              ArrayList RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ArrayList e1 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= e1; RESULT.add(new Nodo("+","CERRADPOS"));listaNodos.add(new Nodo("+","CERRADPOS"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expReg ::= INTERROGACION expReg 
            {
              ArrayList RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		ArrayList e1 = (ArrayList)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= e1; RESULT.add(new Nodo("?","INTERROG"));listaNodos.add(new Nodo("?","INTERROG"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expReg ::= SALTOLINEA 
            {
              ArrayList RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= new ArrayList(); RESULT.add(new Nodo(e,"LEXEMA"));listaNodos.add(new Nodo(e,"LEXEMA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expReg ::= COMILLASIMPLE 
            {
              ArrayList RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= new ArrayList(); RESULT.add(new Nodo(e,"COMILLASIMPLE"));listaNodos.add(new Nodo(e,"LEXEMA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expReg ::= COMILLADOBLE 
            {
              ArrayList RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= new ArrayList(); RESULT.add(new Nodo(e,"COMILLADOBLE"));listaNodos.add(new Nodo(e,"LEXEMA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expReg ::= CADENA 
            {
              ArrayList RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= new ArrayList(); RESULT.add(new Nodo(e,"CADENA"));listaNodos.add(new Nodo(e,"LEXEMA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expReg ::= CONJUNTOEXP 
            {
              ArrayList RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT= new ArrayList(); RESULT.add(new Nodo(e,"CONJEXP"));listaNodos.add(new Nodo(e,"LEXEMA"));
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expReg",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
