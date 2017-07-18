from django.shortcuts import render
from django.views.generic import TemplateView
from django.utils.decorators import method_decorator
from django.contrib.auth.decorators import login_required


class AssetListView(TemplateView):
    @method_decorator(login_required(login_url='account/login'))
    def get(self, request):
        pass


class AssetAddView(TemplateView):
    @method_decorator(login_required(login_url='account/login'))
    def get(self, request):
        pass

    @method_decorator(login_required(login_url='account/login'))
    def post(self, request):
        pass
