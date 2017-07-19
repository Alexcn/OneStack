from django.db import models
from apps.common.models import BaseModel, BaseTimeModel
from django.contrib.postgres.fields import JSONField, ArrayField


class ServerInfoCollection(BaseTimeModel):
    id = models.BigAutoField(primary_key=True)
    # server = models.ForeignKey('Server', db_index=False)
    cpu_utilization = models.DecimalField(max_digits=16, decimal_places=2, blank=True)
    mem_utilization = models.DecimalField(max_digits=16, decimal_places=2, blank=True)
    disk_info = JSONField(blank=True, null=True)
    net_info = JSONField(blank=True, null=True)
    tcp_connection = models.IntegerField(blank=True)

    class Meta:
        db_table = 'server_info_collections'


class ServerGroup(BaseModel):
    server_id = ArrayField(models.IntegerField())
    group_name = models.CharField(max_length=128)
    description = models.TextField(blank=True, null=True)

    class Meta:
        db_table = 'server_groups'


class APIAddress(BaseModel):
    api_address = models.CharField(max_length=2048)
    method = models.CharField(max_length=10, default='GET')    # 需要添加状态字段，使用枚举类型
    access_frequency = models.IntegerField(default=30)         # 每隔30s访问一次
    params = JSONField(null=True, blank=True)
    description = models.TextField(blank=True, null=True)

    class Meta:
        db_table = 'api_addresses'


class APIMonitorInfoCollection(BaseTimeModel):
    id = models.BigAutoField(primary_key=True)
    return_code = models.IntegerField()
    api_address = models.ForeignKey('APIAddress', db_index=False)
    status = models.CharField(max_length=10)
    return_data = models.CharField(max_length=5000, blank=True, null=True)
    response_time = models.IntegerField(blank=True)             # 单位是毫秒

    class Meta:
        db_table = 'api_monitor_info_collections'


class VisitTrackWebsite(BaseTimeModel):
    domain_name = models.CharField(max_length=512)
    track_code = models.TextField(blank=True)
    description = models.TextField(blank=True)

    class Meta:
        db_table = 'visit_track_websites'


class VisitTrackWebsiteInfoCollection(BaseTimeModel):
    id = models.BigAutoField(primary_key=True)
    visit_track_website = models.ForeignKey('VisitTrackWebsite', db_index=False)
    visit_url = models.CharField(max_length=2048, blank=True)
    visitor_ip = models.CharField(max_length=32, blank=True, null=True)

    class Meta:
        db_table = 'visit_track_website_info_collections'


class MonitorWebsite(BaseModel):
    access_frequency = models.IntegerField(blank=True, default=30)  # 每隔30s访问一次
    description = models.TextField(blank=True, null=True)

    class Meta:
        db_table = 'monitor_websites'


class WebsiteMonitorInfoCollection(BaseTimeModel):
    id = models.BigAutoField(primary_key=True)
    monitor_website = models.ForeignKey('MonitorWebsite', db_index=False)
    return_code = models.IntegerField()
    response_time = models.IntegerField()
    visit_location = models.CharField(max_length=1024, blank=True, null=True)

    class Meta:
        db_table = 'website_monitor_info_collections'


class AlertCondition(BaseModel):
    event_type = models.CharField(max_length=1024)
    value = models.DecimalField(max_digits=16, decimal_places=2)
    max_alert_times = models.IntegerField()
    interval = models.IntegerField(default=30)      # 默认时间间隔为30s
    description = models.TextField(blank=True, null=True)

    class Meta:
        db_table = 'alert_conditions'


class AlertEvent(BaseModel):
    alert_condition = models.ForeignKey('AlertCondition')
    alert_status = models.CharField(max_length=10)
    alert_action = models.ForeignKey('AlertAction')

    class Meta:
        db_table = 'alert_events'


class AlertAction(BaseModel):
    actions = JSONField()

    class Meta:
        db_table = 'alert_actions'


class EventReceiveUser(BaseModel):
    user_id = ArrayField(models.IntegerField())

    class Meta:
        db_table = 'event_receive_users'


class EventReceiveGroup(BaseModel):
    group_id = ArrayField(models.IntegerField())

    class Meta:
        db_table = 'event_receive_groups'
