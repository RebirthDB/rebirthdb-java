// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../templates/Test.java
package com.rethinkdb.gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.TestingFramework;
import com.rethinkdb.gen.ast.ReqlFunction3;
import com.rethinkdb.gen.ast.Table;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.rethinkdb.TestingCommon.*;
import static org.junit.Assert.assertEquals;

public class MutationWriteHook {
    // Tests insertion with a write hook function
    Logger logger = LoggerFactory.getLogger(MutationWriteHook.class);
    public static final RethinkDB r = RethinkDB.r;
    public static final Table tbl = r.db("test").table("tbl");

    Connection conn;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up.");
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
        try {
            r.db("test").tableCreate("tbl").run(conn);
            r.db("test").table(tbl).wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        logger.info("Tearing down.");
        r.db("rethinkdb").table("_debug_scratch").delete().run(conn);
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.db("test").tableDrop("tbl").run(conn);
        r.dbDrop("test").run(conn);
        conn.close(false);
    }

    // Matches Python's str() function, which we use.
    // TODO: We might want to handle this in a visit_Call in convert_tests.py instead.
    private static String str(long i) {
        return String.valueOf(i);
    }

    // A hack to concatenate two List<Long>s -- see is_array_add in convert_tests.py.
    private static List<Long> concatLong(List<Long> x, List<Long> y) {
        List<Long> ret = new ArrayList<Long>(x);
        ret.addAll(y);
        return ret;
    }

    // Autogenerated tests below

    @Test(timeout=120000)
    public void test() throws Exception {

        {
            // mutation/write_hook.yaml line #6
            /* partial({'created': 1 }) */
            Partial expected_ = partial(r.hashMap("created", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: n.merge({'num':1, 't': ctx['timestamp'], 'e': n['id'] == ctx['primary_key']})) */
            logger.info("About to run line #6: tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap('num', 1L).with('t', ctx.bracket('timestamp')).with('e', n.bracket('id').eq(ctx.bracket('primary_key')))))");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap("num", 1L).with("t", ctx.bracket("timestamp")).with("e", n.bracket("id").eq(ctx.bracket("primary_key"))))),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #6");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #6:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #10
            /* partial({'inserted':1, 'errors':0}) */
            Partial expected_ = partial(r.hashMap("inserted", 1L).with("errors", 0L));
            /* tbl.insert({'id': 1}) */
            logger.info("About to run line #10: tbl.insert(r.hashMap('id', 1L))");
            Object obtained = runOrCatch(tbl.insert(r.hashMap("id", 1L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #10");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #10:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #14
            /* [{"id": 1, "num": 1, "t": "PTYPE<TIME>", "e": true}] */
            List expected_ = r.array(r.hashMap("id", 1L).with("num", 1L).with("t", "PTYPE<TIME>").with("e", true));
            /* tbl.merge(lambda row:{'t':row['t'].type_of()}) */
            logger.info("About to run line #14: tbl.merge(row -> r.hashMap('t', row.bracket('t').typeOf()))");
            Object obtained = runOrCatch(tbl.merge(row -> r.hashMap("t", row.bracket("t").typeOf())),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #14");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #14:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #18
            /* partial({'deleted': 1 }) */
            Partial expected_ = partial(r.hashMap("deleted", 1L));
            /* tbl.set_write_hook(null) */
            logger.info("About to run line #18: tbl.setWriteHook((ReqlFunction3) null)");
            Object obtained = runOrCatch(tbl.setWriteHook((ReqlFunction3) null),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #18");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #18:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #22
            /* partial({'created': 1 }) */
            Partial expected_ = partial(r.hashMap("created", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: n.merge({'num':2})) */
            logger.info("About to run line #22: tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap('num', 2L)))");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap("num", 2L))),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #22");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #22:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #27
            /* partial({'replaced': 1 }) */
            Partial expected_ = partial(r.hashMap("replaced", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: n.merge({'num':2})) */
            logger.info("About to run line #27: tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap('num', 2L)))");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> n.merge(r.hashMap("num", 2L))),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #27");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #27:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #31
            /* partial({'replaced':1, 'errors':0}) */
            Partial expected_ = partial(r.hashMap("replaced", 1L).with("errors", 0L));
            /* tbl.get(1).replace({"id": 1, "blah":2}) */
            logger.info("About to run line #31: tbl.get(1L).replace(r.hashMap('id', 1L).with('blah', 2L))");
            Object obtained = runOrCatch(tbl.get(1L).replace(r.hashMap("id", 1L).with("blah", 2L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #31");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #31:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #34
            /* [{"id":1, "blah":2, "num":2}] */
            List expected_ = r.array(r.hashMap("id", 1L).with("blah", 2L).with("num", 2L));
            /* tbl */
            logger.info("About to run line #34: tbl");
            Object obtained = runOrCatch(tbl,
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #34");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #34:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #37
            /* partial({'deleted': 1 }) */
            Partial expected_ = partial(r.hashMap("deleted", 1L));
            /* tbl.set_write_hook(null) */
            logger.info("About to run line #37: tbl.setWriteHook((ReqlFunction3) null)");
            Object obtained = runOrCatch(tbl.setWriteHook((ReqlFunction3) null),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #37");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #37:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #41
            /* err('ReqlQueryLogicError', 'Write hook functions must expect 3 arguments.') */
            Err expected_ = err("ReqlQueryLogicError", "Write hook functions must expect 3 arguments.");
            /* tbl.set_write_hook(lambda ctx: 1) */
            logger.info("About to run line #41: tbl.setWriteHook(ctx -> 1L)");
            tbl.getClass().getMethod("setWriteHook", ReqlFunction3.class);
        }

        {
            // mutation/write_hook.yaml line #46
            /* err('ReqlQueryLogicError', 'Could not prove function deterministic.  Write hook functions must be deterministic.') */
            Err expected_ = err("ReqlQueryLogicError", "Could not prove function deterministic.  Write hook functions must be deterministic.");
            /* tbl.set_write_hook(lambda ctx, o, n: r.js(1)) */
            logger.info("About to run line #46: tbl.setWriteHook((ctx, o, n) -> r.js(1L))");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> r.js(1L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #46");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #46:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #51
            /* partial({'created': 1 }) */
            Partial expected_ = partial(r.hashMap("created", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: null) */
            logger.info("About to run line #51: tbl.setWriteHook((ctx, o, n) -> null)");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> null),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #51");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #51:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #55
            /* partial({'first_error': 'A write hook function must not turn a replace/insert into a deletion.'}) */
            Partial expected_ = partial(r.hashMap("first_error", "A write hook function must not turn a replace/insert into a deletion."));
            /* tbl.insert({}) */
            logger.info("About to run line #55: tbl.insert(r.hashMap())");
            Object obtained = runOrCatch(tbl.insert(r.hashMap()),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #55");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #55:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #59
            /* partial({'replaced': 1 }) */
            Partial expected_ = partial(r.hashMap("replaced", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: {}) */
            logger.info("About to run line #59: tbl.setWriteHook((ctx, o, n) -> r.hashMap())");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> r.hashMap()),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #59");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #59:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #63
            /* partial({'first_error': 'A write hook function must not turn a deletion into a replace/insert.'}) */
            Partial expected_ = partial(r.hashMap("first_error", "A write hook function must not turn a deletion into a replace/insert."));
            /* tbl.delete() */
            logger.info("About to run line #63: tbl.delete()");
            Object obtained = runOrCatch(tbl.delete(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #63");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #63:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #66
            /* partial({'deleted': 1 }) */
            Partial expected_ = partial(r.hashMap("deleted", 1L));
            /* tbl.set_write_hook(null) */
            logger.info("About to run line #66: tbl.setWriteHook((ReqlFunction3) null)");
            Object obtained = runOrCatch(tbl.setWriteHook((ReqlFunction3) null),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #66");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #66:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #70
            /* partial({'created': 1 }) */
            Partial expected_ = partial(r.hashMap("created", 1L));
            /* tbl.set_write_hook(lambda ctx,o,n: r.error("OH NOES!")) */
            logger.info("About to run line #70: tbl.setWriteHook((ctx, o, n) -> r.error('OH NOES!'))");
            Object obtained = runOrCatch(tbl.setWriteHook((ctx, o, n) -> r.error("OH NOES!")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #70");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #70:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #74
            /* partial({'first_error':'Error in write hook: OH NOES!'}) */
            Partial expected_ = partial(r.hashMap("first_error", "Error in write hook: OH NOES!"));
            /* tbl.insert({}) */
            logger.info("About to run line #74: tbl.insert(r.hashMap())");
            Object obtained = runOrCatch(tbl.insert(r.hashMap()),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #74");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #74:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // mutation/write_hook.yaml line #77
            /* partial({'first_error':'Error in write hook: OH NOES!'}) */
            Partial expected_ = partial(r.hashMap("first_error", "Error in write hook: OH NOES!"));
            /* tbl.delete() */
            logger.info("About to run line #77: tbl.delete()");
            Object obtained = runOrCatch(tbl.delete(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #77");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #77:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
