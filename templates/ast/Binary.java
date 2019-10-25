<%inherit file="../AstSubclass.java"/>

<%block name="add_imports">
import com.rethinkdb.net.Converter;
import org.jetbrains.annotations.Nullable;
</%block>

<%block name="member_vars">
    @Nullable byte[] b64Data;
</%block>

<%block name="constructors">
    public ${classname}(byte[] bytes){
        this(new Arguments());
        b64Data = bytes;
    }
    public ${classname}(Object arg) {
        this(new Arguments(arg), null);
    }
    public ${classname}(Arguments args){
        this(args, null);
    }
    public ${classname}(Arguments args, OptArgs optargs) {
        this(TermType.${term_name}, args, optargs);
    }
    protected ${classname}(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }
</%block>

<%block name="special_methods">
    @Override
    public Object build(){
        if(b64Data != null){
            return Converter.toBinary(b64Data);
        }else{
            return super.build();
        }
    }
</%block>
