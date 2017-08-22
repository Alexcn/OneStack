from rest_framework import serializers
from apps.assets.models import HardwareAsset, SoftwareAsset, ITAsset


class HardwareAssetSerializer(serializers.ModelSerializer):
    class Meta:
        model = HardwareAsset
        fields = None


class SoftwareAssetSerializer(serializers.ModelSerializer):
    pass

