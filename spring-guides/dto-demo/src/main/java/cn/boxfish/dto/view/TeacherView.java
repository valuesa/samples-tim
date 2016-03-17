package cn.boxfish.dto.view;

import org.jdto.annotation.Source;
import org.jdto.annotation.Sources;
import org.jdto.mergers.DateFormatMerger;
import org.jdto.mergers.StringFormatMerger;

import java.io.Serializable;

/**
 * Created by LuoLiBing on 16/3/17.
 */
public class TeacherView implements Serializable {

    private String name;

    @Source(value = "birthday", merger = DateFormatMerger.class, mergerParam = "yyyy年MM月dd日")
    private String birthday;

    @Sources(value = {@Source("name"), @Source("birthday")},
            merger = StringFormatMerger.class, mergerParam = "%s 的生日是 %s")
    private String description;

    /*@Source(value = "gender", merger = EnumMerger.class, mergerParam = "")
    private String gender;*/
}
