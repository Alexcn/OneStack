from django.db import models
from apps.common.models import BaseModel
from django.contrib.postgres.fields import JSONField


class ITAsset(BaseModel):
    assets_type_choices = {
        'server': '服务器',
        'switch': '交换机',
        'route': '路由器',
        'printer': '打印机',
        'scanner': '扫描仪',
        'firewall': '防火墙',
        'storage': '存储设备',
        'wifi': '无线设备',
        'os': '操作系统',
        'docker': 'docker容器',
    }
    model_type = models.CharField(max_length=32, blank=True, null=True)
    name = models.CharField(max_length=512, db_index=True, null=True)
    has_activated = models.BooleanField(default=False, verbose_name='是否激活')
    description = models.TextField(blank=True, null=True, verbose_name='备注信息')

    class Meta:
        db_table = 'it_assets'


class HardwareAsset(ITAsset):

    ip_set = JSONField(verbose_name='IP地址')
    mac_address_set = JSONField(verbose_name='MAC地址')
    management_port = models.IntegerField(default=22, verbose_name='管理端口')
    idc_location = models.CharField(max_length=512, blank=True, null=True, verbose_name='IDC机房位置')
    hardware_type = models.CharField(max_length=512, blank=True, null=True)
    cpu = JSONField(blank=True, null=True, verbose_name='CPU配置')
    memory = JSONField(blank=True, null=True)
    disk = JSONField(blank=True, null=True)
    network_card = JSONField(blank=True, null=True)
    os_type = models.CharField(max_length=32, blank=True, null=True, verbose_name='服务器类型')
    os_version = models.CharField(max_length=32, blank=True, null=True, verbose_name='服务器版本')
    asset_number = models.CharField(max_length=128, blank=True, null=True)
    sn = models.CharField(max_length=128, blank=True, null=True)
    cabinet_number = models.CharField(max_length=128, blank=True, null=True)
    server_location = models.CharField(max_length=512, blank=True, null=True)
    server_type = models.CharField(max_length=128, blank=True, null=True)
    run_env = models.CharField(max_length=128, blank=True, null=True)
    server_status = models.CharField(max_length=128, blank=True, null=True)
    put_shelf_time = models.DateTimeField(verbose_name='上架时间')

    class Meta:
        db_table = 'hardware_assets'


class SoftwareAsset(ITAsset):
    version = models.CharField(max_length=128, blank=True, null=True, verbose_name='软件版本')
    license_type = models.CharField(max_length=128, blank=True, null=True, verbose_name='许可证类型')
    hardware_id = models.IntegerField(blank=True, null=True, verbose_name='运行硬件的ID')

    class Meta:
        db_table = 'software_assets'

