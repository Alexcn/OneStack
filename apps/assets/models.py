from django.db import models
from apps.common.models import BaseModel
from django.contrib.postgres.fields import JSONField


# Create your models here.


class ITAsset(BaseModel):
    model_type = models.CharField(max_length=32, blank=True, null=True)
    name = models.CharField(max_length=512, db_index=True, null=True)
    # ip_set = JSONField(verbose_name='IP地址')
    # mac_address_set = JSONField(verbose_name='MAC地址')
    # management_port = models.IntegerField(default=22, verbose_name='管理端口')
    # idc_location = models.CharField(max_length=512, blank=True, null=True, verbose_name='IDC机房位置')
    # hardware_type = models.CharField(max_length=512, blank=True, null=True)
    # cpu = JSONField(blank=True, null=True, verbose_name='CPU配置')
    # memory = JSONField(blank=True, null=True)
    # disk = JSONField(blank=True, null=True)
    # network_card = JSONField(blank=True, null=True)
    # os_type = models.CharField(max_length=32, blank=True, null=True, verbose_name='服务器类型')
    # os_version = models.CharField(max_length=32, blank=True, null=True, verbose_name='服务器版本')
    # asset_number = models.CharField(max_length=128, blank=True, null=True)
    # sn = models.CharField(max_length=128, blank=True, null=True)
    # cabinet_number = models.CharField(max_length=128, blank=True, null=True)
    # server_location = models.CharField(max_length=512, blank=True, null=True)
    # server_type = models.CharField(max_length=128, blank=True, null=True)
    # run_env = models.CharField(max_length=128, blank=True, null=True)
    # server_status = models.CharField(max_length=128, blank=True, null=True)
    # put_shelf_time = models.DateTimeField(verbose_name='上架时间')
    has_activated = models.BooleanField(default=False, verbose_name='是否激活')
    description = models.TextField(blank=True, null=True, verbose_name='备注信息')


class HardwareAsset(ITAsset):
    pass


class SoftwareAsset(ITAsset):
    pass


class ServerAsset(HardwareAsset):
    pass
