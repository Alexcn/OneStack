from django.shortcuts import render
from django.views.generic import TemplateView
from django.utils.decorators import method_decorator
# from django.contrib.auth.decorators import login_required
from apps.common.utils import LoginRequiredMixin


class AssetListView(LoginRequiredMixin, TemplateView):
    def get(self, request):
        pass


class AssetAddView(LoginRequiredMixin, TemplateView):
    def get(self, request):
        pass

    def post(self, request):
        pass
