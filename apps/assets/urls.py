from django.conf.urls import url
from .views import HardwareAssetListView, HardwareAssetAddView, HardwareAssetUpdateView

urlpatterns = [
    # url(r'^list/$', AssetListView.as_view(), name='dashboard'),
    url(r'^hardware/add/$', HardwareAssetAddView.as_view(), name='hardware_add'),
    url(r'^hardware/update/(?P<pk>[0-9]+)/$', HardwareAssetUpdateView.as_view(), name='hardware_update'),
    url(r'^hardware/list/$', HardwareAssetListView.as_view(), name='hardware_list'),
]
