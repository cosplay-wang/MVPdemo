package demo.cosplay.com.mvpdemo.bean;

/**
 * Created by Hasee on 2017/9/10.
 */

public class NewsBean {


    /**
     * thumbnail : http://d.ifengimg.com/w698_h392_q75/p0.ifengimg.com/source2/pmop/storage_img/2017/08/10/pmop-180329550_3.jpg
     * title : 货车擦挂谈赔偿 一言不合火拼拳脚
     * online : 0
     * phvideo : {"channelName":"24小时热播","length":401}
     * id : 508087b2-ebc8-4883-b77c-852802ac6c57
     * style : {"view":"bigimg"}
     * showType : 1
     * flag : ifengvideos
     * documentId : imcp_crc_3913104928
     * staticId : video_508087b2-ebc8-4883-b77c-852802ac6c57
     * type : phvideo
     * link : {"type":"phvideo","url":"508087b2-ebc8-4883-b77c-852802ac6c57"}
     * commentsUrl : http://share.iclient.ifeng.com/sharenews.f?guid=508087b2-ebc8-4883-b77c-852802ac6c57
     * simId : clusterId_15697143
     * comments : 526
     * commentsall : 772
     * reftype : remcommend
     */

    private String thumbnail;
    private String title;
    private String online;
    private PhvideoBean phvideo;
    private String id;
    private StyleBean style;
    private int showType;
    private String flag;
    private String documentId;
    private String staticId;
    private String type;
    private LinkBean link;
    private String commentsUrl;
    private String simId;
    private String comments;
    private String commentsall;
    private String reftype;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public PhvideoBean getPhvideo() {
        return phvideo;
    }

    public void setPhvideo(PhvideoBean phvideo) {
        this.phvideo = phvideo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getStaticId() {
        return staticId;
    }

    public void setStaticId(String staticId) {
        this.staticId = staticId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsall() {
        return commentsall;
    }

    public void setCommentsall(String commentsall) {
        this.commentsall = commentsall;
    }

    public String getReftype() {
        return reftype;
    }

    public void setReftype(String reftype) {
        this.reftype = reftype;
    }

    public static class PhvideoBean {
        /**
         * channelName : 24小时热播
         * length : 401
         */

        private String channelName;
        private int length;

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    public static class StyleBean {
        /**
         * view : bigimg
         */

        private String view;

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }
    }

    public static class LinkBean {
        /**
         * type : phvideo
         * url : 508087b2-ebc8-4883-b77c-852802ac6c57
         */

        private String type;
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
