create schema if not exists rsvp;
use rsvp;

create table if not exists rsvp (
	rsvp_id int not null auto_increment primary key,
    guest_name varchar(50) not null,
    total_attending int not null
);

mysql://b7e8449df1a601:b4f0c290@us-cdbr-east-06.cleardb.net/heroku_bd60f31e3fde738?reconnect=true
mysql://b7e8449df1a601:b4f0c290@us-cdbr-east-06.cleardb.net/heroku_bd60f31e3fde738?reconnect=true