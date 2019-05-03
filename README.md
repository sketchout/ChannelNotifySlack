# ChannelNotifySlack
Send Message to Slack Channel(by Webhook URL)

# Usage in Java
~~~
GroupNotifyLINE ln = new GroupNotifyLINE();
ln.postNotify(_WEBHOOK_URL, sb.toString(),"alert-bot");
~~~

## postNotify()
~~~
HttpURLConnection connection = getConnection(token, new URL(_WEBHOOK_URL));
StringBuffer sb = new StringBuffer();

sb.append("{ \"text\": \""+ strToMd(textMessage,"BOLD") + "\" ,");
sb.append(" \"username\": \""+ botName + "\" }");	// replace default - incoming-webhook(app)

connection.getOutputStream().write(sb.toString().getBytes("UTF-8"));

connection.getInputStream();

int statusCode = connection.getResponseCode();
~~~

# Get Your WEB HOOK URL
1. Choose a channel at https://my.slack.com/services/new/incoming-webhook/   
2. Add Incoming WebHooks integration, get Webhook URL  
