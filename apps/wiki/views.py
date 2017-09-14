from django.shortcuts import render
from django.views.generic import View, ListView, CreateView
# from apps.common.utils import LoginRequiredMixin
from django.contrib.auth.mixins import LoginRequiredMixin

from .models import Wiki


class WikiListView(LoginRequiredMixin, ListView):
    pass

class WikiAddView(LoginRequiredMixin, View):
    pass


class WikiEditView(LoginRequiredMixin, View):
    pass


class WikiDetailView(LoginRequiredMixin, View):
    pass
