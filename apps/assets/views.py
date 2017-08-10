from django.shortcuts import render
from django.views.generic import ListView, CreateView, UpdateView, DetailView
from django.utils.decorators import method_decorator
# from apps.common.utils import LoginRequiredMixin
from django.contrib.auth.mixins import LoginRequiredMixin
from .models import HardwareAsset
from .forms import HardwareAssetForm


class HardwareAssetListView(LoginRequiredMixin, ListView):
    model = HardwareAsset
    template_name = 'assets/hardware_asset_list.html'


class HardwareAssetAddView(LoginRequiredMixin, CreateView):
    model = HardwareAsset
    template_name = 'asset/hardware_asset_add.html'


class HardwareAssetUpdateView(LoginRequiredMixin, UpdateView):
    model = HardwareAsset
    template_name = 'asset/hardware_asset_add.html'


class HardwareAssetDetailView(LoginRequiredMixin, DetailView):
    template_name = 'asset/hardware_asset_detail.html'
